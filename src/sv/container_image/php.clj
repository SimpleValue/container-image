(ns sv.container-image.php
  (:require [sv.container-image.apt :as apt]))

(defn install
  [_]
  [["add-apt-repository" "-y" "ppa:ondrej/php"]
   (apt/install {:apt/packages ["php7.4"
                                "php7.4"
                                "php7.4-curl"
                                "php7.4-gd"
                                "php7.4-mbstring"
                                "php7.4-zip"
                                "php7.4-json"
                                "php7.4-common"
                                "php7.4-bcmath"]})
   ["php" "-r" "copy('https://getcomposer.org/installer', 'composer-setup.php');"]
   ["php" "composer-setup.php" "--install-dir=/usr/local/bin" "--filename=composer"]
   ["rm" "composer-setup.php"]
   ])

