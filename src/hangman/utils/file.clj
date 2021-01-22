(ns hangman.utils.file
  (:require [clojure.java.io :as io]))

(def resource-reader #(io/reader (io/resource %)))

(defn with-file
  [filename operation]
  (with-open [rdr (resource-reader filename)]
    (operation rdr)))

(defn get-line
  [filename line]
  (with-file filename #(nth (line-seq %) line)))
