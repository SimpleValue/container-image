(ns sv.container-image.kubectl
  "Installs kubectl for Kubernetes.

   Based on:
   https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/#install-using-native-package-management
  "
  (:require [sv.container-image.apt :as apt]))

(defn install
  [params]
  [["curl" "-fsSLo" "/usr/share/keyrings/kubernetes-archive-keyring.gpg" "https://packages.cloud.google.com/apt/doc/apt-key.gpg"]

   ["bash" "-c" "echo \"deb [signed-by=/usr/share/keyrings/kubernetes-archive-keyring.gpg] https://apt.kubernetes.io/ kubernetes-xenial main\" | tee /etc/apt/sources.list.d/kubernetes.list"]

   (apt/update params)
   (apt/install {:apt/packages ["kubectl"]})
   ])
