(ns sv.container-image.datomic
  (:require [clojure.string :as str]))

(defn datomic-download-url
  [{:keys [version]}]
  (str "https://datomic-pro-downloads.s3.amazonaws.com/"
       version
       "/datomic-pro-"
       version
       ".zip"))

(defn properties-str
  [properties-map]
  (str (str/join "\n"
                 (map (fn [[k v]]
                        (str/join "=" [(name k) v]))
                      properties-map))
       "\n"))

(comment
  (properties-str {:protocol "dev"
                   :host "localhost"})
  )

(defn install
  [params]
  (let [datomic (:datomic params)]
    [["wget"
      "-O" "datomic.zip"
      (datomic-download-url datomic)]
     ["unzip" "datomic.zip"]
     ["mv"
      (str "datomic-pro-"
           (:version datomic))
      "/opt/datomic"]
     ["rm" "datomic.zip"]
     ["mkdir" "-p" "/opt/datomic/config"]
     [spit
      "/opt/datomic/config/transactor.properties"
      (properties-str (:config datomic))]
     ]))
