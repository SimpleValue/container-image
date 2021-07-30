(ns sv.container-image.terraform
  "Installs Terraform.

   Based on:
   https://learn.hashicorp.com/tutorials/terraform/install-cli
  "
  (:require [sv.container-image.apt :as apt]))

(defn install
  [params]
  [["bash" "-c" "curl -fsSL https://apt.releases.hashicorp.com/gpg | apt-key add -"]

   ["bash" "-c" "apt-add-repository \"deb [arch=amd64] https://apt.releases.hashicorp.com $(lsb_release -cs) main\""]

   (apt/update params)
   (apt/install {:apt/packages ["terraform"]})
   ])
