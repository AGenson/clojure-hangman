(ns hangman.utils.string
  (:require [clojure.string :as string]))

(def char-set #(set (char-array %)))

(def clean (comp string/upper-case string/trim))

(def split-char #(string/split % #""))

(def includes? #(string/includes? %1 (str %2)))

(def letter? #(re-matches #"[a-zA-Z]" %))

(defn replace-at
  [s index replacement]
  (str (subs s 0 index)
       replacement
       (subs s (inc index))))
