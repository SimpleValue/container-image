(ns sv.container-image.kubectl
  "Installs kubectl for Kubernetes.

   Based on:
   https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/#install-kubectl-binary-with-curl-on-linux
  "
  )

(defn install
  [_params]
  (let [version (slurp (java.net.URL. "https://dl.k8s.io/release/stable.txt"))]
    [["curl" "-LO" (format "https://dl.k8s.io/release/%s/bin/linux/amd64/kubectl"
                           version)]
     ["install" "-o" "root" "-g" "root" "-m" "0755" "kubectl" "/usr/local/bin/kubectl"]
     ]))
