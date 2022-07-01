(ns sv.container-image.github-actions-runner)

(defn install
  [params]
  (let [version (::version params
                           "2.294.0")
        dir "/opt/github-actions-runner"]
    [
     ["mkdir" "-p" dir]
     ["curl"
      "-o" (str dir
                "/actions-runner.tar.gz")
      "-L"
      (str
       "https://github.com/actions/runner/releases/download/v"
       version
       "/actions-runner-linux-x64-"
       version
       ".tar.gz")]
     ["bash" "-c" "(cd /opt/github-actions-runner && tar xzf ./actions-runner.tar.gz)"]
     ["chown" "-R" "dev" "/opt/github-actions-runner"]
     ]
    ))

(comment
  (require 'sv.container-image.process)

  (sv.container-image.process/execute!
   (install {}))

  )
