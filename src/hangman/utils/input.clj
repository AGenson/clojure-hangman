(ns hangman.utils.input
  (:require [hangman.utils.string :refer [clean letter? split-char]]))

(defn word-validator
  [value]
  (if (reduce #(and %1 (letter? %2))
              true
              (split-char value))
    value))

(def letter-validator #(first (letter? %)))

(def get-input (comp clean read-line))

(def get-word-input (comp word-validator get-input))

(def get-letter-input (comp letter-validator get-input))
