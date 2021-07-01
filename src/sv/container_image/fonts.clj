(ns sv.container-image.fonts
  (:require [sv.container-image.apt :as apt]))

(def fonts-conf
  "<?xml version='1.0'?>
<!DOCTYPE fontconfig SYSTEM 'fonts.dtd'>
<fontconfig>
  <!-- Set preferred serif, sans serif, and monospace fonts. -->
  <alias>
    <family>serif</family>
    <prefer><family>Ubuntu Condensed</family></prefer>
  </alias>
  <alias>
    <family>sans-serif</family>
    <prefer><family>Ubuntu</family></prefer>
  </alias>
  <alias>
    <family>sans</family>
    <prefer><family>Ubuntu</family></prefer>
  </alias>
  <alias>
    <family>monospace</family>
    <prefer><family>Ubuntu Monospace</family></prefer>
  </alias>
</fontconfig>")

(def apt-packages
  ["msttcorefonts"
   "fonts-liberation"
   "fonts-roboto"
   "fonts-ubuntu"
   "fonts-noto-color-emoji"
   "fonts-noto-cjk"
   "fonts-ipafont-gothic"
   ;; "fonts-wqy-zenhei"
   "fonts-kacst"
   "fonts-freefont-ttf"
   "fonts-thai-tlwg"
   "fonts-indic"
   "fontconfig"
   "libfontconfig1"])

(def accept-mscorefonts-eula
  "echo 'ttf-mscorefonts-installer msttcorefonts/accepted-mscorefonts-eula select true' | debconf-set-selections")

(defn install
  [_]
  [["bash" "-c" (str "mkdir -p /etc/fonts/ && echo \""
                     fonts-conf
                     "\" > /etc/fonts/local.conf")]
   ["bash" "-c" accept-mscorefonts-eula]
   (apt/install {:apt/packages apt-packages})
   ["fc-cache" "-f" "-v"]
   ]
  )
