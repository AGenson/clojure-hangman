(ns hangman.data.dict
  (:require [hangman.utils.file :refer [get-line]]
            [hangman.utils.string :refer [clean]]))

(def DICT_SIZE 58109)

(def FILENAME "dictionary.txt")

(def rand-line #(rand-int DICT_SIZE))

(def get-random-word #(clean (get-line FILENAME (rand-line))))
