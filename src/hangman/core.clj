(ns hangman.core
  (:require [hangman.logic.prompt :refer [prompt-start]])
  (:gen-class))

(defn -main
  [& _]
  (prompt-start))
