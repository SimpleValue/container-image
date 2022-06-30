(ns sv.container-image.clj-kondo)

(defn install
  [_params]
  [
   ["bash" "-c" "curl https://raw.githubusercontent.com/clj-kondo/clj-kondo/master/script/install-clj-kondo | bash"]])
