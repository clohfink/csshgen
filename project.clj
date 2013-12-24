(defproject csshgen "0.1.0-SNAPSHOT"
  :description "Generate a clusers config file for cssh against servers in a Rackspace account"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-rackspace "0.1.2-SNAPSHOT"]
                 [org.clojure/data.json "0.2.0"]
                 [clj-http "0.7.8"]]
  :main ^:skip-aot csshgen.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
