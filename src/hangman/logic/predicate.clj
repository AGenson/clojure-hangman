(ns hangman.logic.predicate
  (:require [clojure.set :refer [difference]])
  (:require [hangman.utils.string :refer [includes? char-set]]))

(defn good-guess?
  [{word :word} letter]
  (includes? word letter))

(defn win?
  [{:keys [word good-guesses]}]
  (empty? (difference (char-set word) good-guesses)))

(defn loose?
  [{:keys [bad-guesses]}]
  (< 5 (count bad-guesses)))

(def end? #(or (win? %) (loose? %)))
