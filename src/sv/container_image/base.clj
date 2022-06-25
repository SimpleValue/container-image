(ns sv.container-image.base
  (:require [sv.container-image.apt :as apt]
            [sv.container-image.fonts :as fonts]
            [sv.container-image.clojure :as clojure]
            [sv.container-image.cloud-profiler :as cloud-profiler]
            [sv.container-image.process :as process]
            ))

(def default-params
  {:apt/packages ["dumb-init"
                  "libappindicator3-1"
                  "pdftk"
                  "unzip"
                  "locales"
                  "gconf-service"
                  "libasound2"
                  "libatk1.0-0"
                  "libc6"
                  "libcairo2"
                  "libcups2"
                  "libdbus-1-3"
                  "libexpat1"
                  "libgcc1"
                  "libgconf-2-4"
                  "libgdk-pixbuf2.0-0"
                  "libglib2.0-0"
                  "libgtk-3-0"
                  "libnspr4"
                  "libpango-1.0-0"
                  "libpangocairo-1.0-0"
                  "libstdc++6"
                  "libx11-6"
                  "libx11-xcb1"
                  "libxcb1"
                  "libxcomposite1"
                  "libxcursor1"
                  "libxdamage1"
                  "libxext6"
                  "libxfixes3"
                  "libxi6"
                  "libxrandr2"
                  "libxrender1"
                  "libxss1"
                  "libxtst6"
                  "libllvm8"
                  "libgbm-dev"
                  "ca-certificates"
                  "libappindicator1"
                  "libnss3"
                  "lsb-release"
                  "xdg-utils"
                  "wget"
                  "xvfb"
                  "curl"
                  "tmux"
                  "nano"
                  "procps"
                  "htop"
                  "git"
                  "ssh-client"
                  "iputils-ping"
                  "dnsutils"
                  "socat"
                  "ffmpeg"
                  "file"
                  ]})

(defn install
  [params]
  (concat
   (apt/init params)
   (fonts/install params)
   [(apt/install default-params)]
   (clojure/install params)
   (cloud-profiler/install params)
   )
  )

(defn install!
  ([params]
   (process/execute! (install params)))
  ([]
   (install! {})))

(defn -main
  [& args]
  (install!))
