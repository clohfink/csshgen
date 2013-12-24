(ns csshgen.core
  (:require [rackspace.identity :as rauth]
            [rackspace.servers.v2.service :as rservers]
            [clojure.data.json :as json]
            [clojure.string :as string])
  (:gen-class))

(defn get-servers[token region]
  (:servers (json/read-str (:body (rservers/get-server-list token region)) :key-fn keyword )))

(defn all-names[server]
  (concat (map #(subs server 0 %)
               (for [[i e] (map vector (iterate inc 0) server)
                     :when (#(= \- %) e)] i))
          [server]))

(defn frmt[user n i]
  (str n " " (string/join " " (map #(str user "@" %) i))))

(defn -main
  [& args]
  (def token (rauth/login (first args) :apikey (nth args 1)))
  (def m (reduce #(merge-with concat %1 %2) (map
            #(into {} (map vector
                           (map keyword (all-names (:name %)))
                           (repeat (-> % :addresses :private first :addr list))))
            (get-servers token (keyword (nth args 2))))))
  (doseq [i (sort (map #(frmt (nth args 3) (-> % first name) (-> % rest first)) m))] (println i))
)
