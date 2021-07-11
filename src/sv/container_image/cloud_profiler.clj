(ns sv.container-image.cloud-profiler)

(defn install
  [params]
  [["mkdir" "-p" "/opt/cprof"]
   ["bash" "-c"  "wget -q -O- https://storage.googleapis.com/cloud-profiler/java/latest/profiler_java_agent.tar.gz | tar xzv -C /opt/cprof"]
   ]
  )
