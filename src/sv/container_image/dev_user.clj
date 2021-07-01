(ns sv.container-image.dev-user)

(defn install
  [params]
  [["useradd" "-ms" "/bin/bash" "dev"]
   ["usermod" "-aG" "sudo" "dev"]
   ["apt-get" "install" "-y" "sudo"]
   ["bash" "-c" "echo 'dev    ALL=(ALL) NOPASSWD: ALL' >> /etc/sudoers"]]
  )
