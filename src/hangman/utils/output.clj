(ns hangman.utils.output)

(defn print-flush
  [msg]
  (clojure.core/print msg)
  (flush))

(def clear-screen #(print-flush "\033[H\033[2J"))

(defn clear-print
  ([optional-msg]
   (clear-screen)
   (if optional-msg
     (print-flush optional-msg))))
