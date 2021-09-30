(ns sv.container-image.openvscode
  "Installs [OpenVSCode Server](https://github.com/gitpod-io/openvscode-server/)")

(defn install
  [params]
  (let [version (::version params
                           "1.60.2")]
    (concat
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
     (when-let [max-user-watches (::max-user-watches params
                                                     524288)]
       ;; allows Visual Studio Code to watch large folders, see:
       ;; https://code.visualstudio.com/docs/setup/linux#_visual-studio-code-is-unable-to-watch-for-file-changes-in-this-large-workspace-error-enospc
       [["bash" "-c"
         (str "echo "
              "'fs.inotify.max_user_watches="
              max-user-watches
              "' >> /etc/sysctl.conf")]])
     )
    ))
