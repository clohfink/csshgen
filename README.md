# csshgen

Generate a clusers config file for cssh against servers in a Rackspace account for a given data center

## Installation

Download from https://github.com/clohfink/csshgen/blob/master/csshgen.jar?raw=true

## Usage

    $ java -jar csshgen.jar rackspaceAccount apikey datacenter username

## Options

- rackspaceAccount : the account you login to mycloud.rackspace.com with
- apikey : said accounts api key
- datacenter: ord, dfw etc
- username that you would login to each of the boxes with (this sets the username@ip in clusters file)

## Examples

java -jar csshgen.jar rackspaceAccount 9aa7770603b266a33f881966976d3811 ord clohfink >> /etc/clusters

cssh ORD-CASSANDRA-11
cssh ORD-CASSANDRA
