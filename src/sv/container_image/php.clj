(ns sv.container-image.php
  (:require [sv.container-image.apt :as apt]))

(defn install
  [_]
  [["add-apt-repository" "-y" "ppa:ondrej/php"]
   (apt/install {:apt/packages ["php7.3"
                                "php7.3"
                                "php7.3-curl"
                                "php7.3-gd"
                                "php7.3-mbstring"
                                "php7.3-zip"
                                "php7.3-json"
                                "php7.3-common"
                                "php7.3-bcmath"
                                "php7.3-gmp"]})
   ["php" "-r" "copy('https://getcomposer.org/installer', 'composer-setup.php');"]
   ["php" "composer-setup.php" "--install-dir=/usr/local/bin" "--filename=composer"]
   ["rm" "composer-setup.php"]
   ])

