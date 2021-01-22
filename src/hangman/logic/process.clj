(ns hangman.logic.process
  (:require [hangman.logic.predicate :refer [good-guess? end? win?]]
            [hangman.data.display :refer [display-data]]
            [hangman.data.model :refer [add-letter]]))

(defn process-data
  [data letter]
  (add-letter data
              (good-guess? data letter)
              letter))

(defn next-move
  [data if-end-fn if-not-end-fn]
  (if (end? data)
    (if-end-fn data)
    (if-not-end-fn data)))
