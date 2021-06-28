(ns sv.container-image.gcloud)

(defn install
  [params]
  [["bash" "-c" "curl https://sdk.cloud.google.com > gcloud-install.sh"]
   ["chmod" "+x" "./gcloud-install.sh"]
   ["./gcloud-install.sh" "--disable-prompts"]]
  )
