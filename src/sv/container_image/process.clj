(ns sv.container-image.process
  (:require [babashka.process :as process]))

(defn execute!
  [cmds]
  (doseq [[c & args :as cmd] cmds]
    (.println System/out (str "EXECUTING COMMAND: " (pr-str cmd)))
    (if (or (fn? c)
            (var? c))
      (apply c args)
      (let [result @(process/process cmd
                                     {:out :inherit
                                      :err :inherit
                                      :extra-env {"DEBIAN_FRONTEND" "noninteractive"}})]
        (when-not (zero? (:exit result))
          (throw (ex-info "command execution failed"
                          {:cmd cmd
                           :exit (:exit result)})))))))
