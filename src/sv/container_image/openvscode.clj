(ns sv.container-image.openvscode
  "Installs [OpenVSCode Server](https://github.com/gitpod-io/openvscode-server/)")

(defn install
  [params]
  (let [version (::version params
                           "1.60.2")]
    [
     ["wget"
      (str "https://github.com/gitpod-io/openvscode-server/releases/download/openvscode-server-v"
           version
           "/openvscode-server-v"
           version
           "-linux-x64.tar.gz")
      "-O" "code-server.tar.gz"]
     ["tar" "-xzf" "code-server.tar.gz"]
     ["rm" "code-server.tar.gz"]
     ["mv"
      (str "openvscode-server-v"
           version
           "-linux-x64")
      "/opt/openvscode"]
     ["chown" "-R" "dev" "/opt/openvscode"]
     ]
    ))
