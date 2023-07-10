(ns sv.container-image.maven
  "Installs https://maven.apache.org/

   Provide the maven version via `[:maven :version]`."
  )

(defn install
  [params]
  (let [version (or (get-in params
                            [:maven
                             :version])
                    "3.9.3")
        url (str "https://dlcdn.apache.org/maven/maven-3/"
                 version
                 "/binaries/apache-maven-"
                 version
                 "-bin.tar.gz")
        tar-name "maven.tar.gz"]
    [["wget" url "-O" tar-name]
     ["tar" "-xzf" tar-name]
     ["rm" tar-name]
     ["mv"
      "-f"
      (str "apache-maven-"
           version)
      "/opt/maven"]
     [spit "/etc/profile.d/maven-path.sh" "export PATH=$PATH:/opt/maven/bin/" :append true]
     ]))
