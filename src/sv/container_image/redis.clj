(ns sv.container-image.redis
  "Installs Redis.")

(defn install
  [_params]
  [
   '[bash -c "curl -fsSL https://packages.redis.io/gpg | gpg --dearmor -o /usr/share/keyrings/redis-archive-keyring.gpg"]
   '[bash -c "echo \"deb [signed-by=/usr/share/keyrings/redis-archive-keyring.gpg] https://packages.redis.io/deb $(lsb_release -cs) main\" | tee /etc/apt/sources.list.d/redis.list"]
   '[apt-get update]
   '[apt-get install -y redis]
   ])
