(ns sv.container-image.openvscode
  "Installs [OpenVSCode Server](https://github.com/gitpod-io/openvscode-server/)

   To allow Visual Studio Code to watch large folders execute this on the host:

       echo fs.inotify.max_user_watches=524288 | sudo tee -a /etc/sysctl.conf && sudo sysctl -p

   See: https://code.visualstudio.com/docs/setup/linux#_visual-studio-code-is-unable-to-watch-for-file-changes-in-this-large-workspace-error-enospc

   This cannot be done during the Docker image build: https://github.com/cdr/code-server/issues/628#issuecomment-636526989
   ")

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
