(ns sv.container-image.apt
  (:refer-clojure :exclude [update]))

(defn update
  [_]
  ["apt-get" "-qq" "update"])

(defn install
  [{:keys [apt/packages]}]
  (vec
   (concat ["apt-get" "-y" "-qq" "--no-install-recommends" "install"]
           (distinct packages))))

(defn clean
  [_]
  ["apt-get" "-qq" "clean"])

(defn init
  [params]
  [(update params)
   (install {:apt/packages ["software-properties-common"]})
   ["bash" "-c" "apt-add-repository \"deb http://archive.canonical.com/ubuntu $(lsb_release -sc) partner\""]
   (update params)])
