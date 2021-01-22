(ns hangman.data.model)

(defn initialize-data
  [word]
  {:word word
   :good-guesses #{}
   :bad-guesses #{}})

(defn gen-letter-adder
  [key]
  (fn [data letter] (update data key #(conj % letter))))

(def add-good-letter (gen-letter-adder :good-guesses))

(def add-bad-letter (gen-letter-adder :bad-guesses))

(defn add-letter
  [data is-good letter]
  (if is-good
    (add-good-letter data letter)
    (add-bad-letter data letter)))
