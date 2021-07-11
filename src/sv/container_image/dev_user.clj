(ns sv.container-image.dev-user)

(defn install
  [params]
  [["useradd" "-ms" "/bin/bash" "dev"]
   ["usermod" "-aG" "sudo" "dev"]
   ["apt-get" "install" "-y" "sudo"]
   ["bash" "-c" "echo 'dev    ALL=(ALL) NOPASSWD: ALL' >> /etc/sudoers"]

   ;; The `/app` folder (with the main application) should be owned by
   ;; the dev user, so that it is allowed to create and modify files
   ;; in this folder:
   ["mkdir" "-p" "/app"]
   ["chown" "dev" "/app"]
   ]
  )
