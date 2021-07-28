(ns sv.container-image.gcloud
  "Installs the Google Cloud SDK (based on:
   https://cloud.google.com/sdk/docs/install#deb)"
  (:require [sv.container-image.apt :as apt]))

(defn install
  [params]
  [(apt/update params)
   (apt/install {:apt/packages ["apt-transport-https" "ca-certificates" "gnupg"]})
   ["bash" "-c" "echo \"deb [signed-by=/usr/share/keyrings/cloud.google.gpg] https://packages.cloud.google.com/apt cloud-sdk main\" | tee -a /etc/apt/sources.list.d/google-cloud-sdk.list"]
   ["bash" "-c" "curl https://packages.cloud.google.com/apt/doc/apt-key.gpg | apt-key --keyring /usr/share/keyrings/cloud.google.gpg add -"]
   (apt/update params)
   (apt/install {:apt/packages ["google-cloud-sdk"]})
   ]
  )
