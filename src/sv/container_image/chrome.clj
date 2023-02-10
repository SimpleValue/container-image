(ns sv.container-image.chrome
  "Installs Google Chrome.")

(defn install
  [_params]
  (let [deb "./google-chrome-stable_current_amd64.deb"]
    [
     ["curl" "-LO"
"https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb"]
     ["apt-get" "install" "-y" deb]
     ["rm" deb]
     ]))
