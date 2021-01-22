(ns hangman.logic.prompt
  (:require [hangman.data.model :refer [initialize-data]]
            [hangman.data.display :refer [display-data]]
            [hangman.utils.output :refer [print-flush clear-print]]
            [hangman.utils.input :refer [get-letter-input get-word-input]]
            [hangman.logic.process :refer [process-data next-move]]
            [hangman.data.dict :refer [get-random-word]]))

(declare prompt-word prompt-move prompt-replay)

(defn prompt-start
  []
  (clear-print "Use word generator? Y/[N]: ")
  (if (= \Y (get-letter-input))
    (prompt-move (initialize-data (get-random-word)))
    (prompt-word)))

(defn prompt-word
  []
  (clear-print "Enter your word: ")
  (if-let [word (get-word-input)]
    (prompt-move (initialize-data word))
    (prompt-word)))

(defn prompt-move
  [data]
  (display-data data)
  (print-flush "Enter a letter: ")
  (if-let [letter (get-letter-input)]
    (next-move (process-data data letter)
               prompt-replay
               prompt-move)
    (prompt-move data)))

(defn prompt-replay
  [data]
  (display-data data :solution)
  (print-flush "\nPlay again? Y/[N]: ")
  (if (= \Y (get-letter-input))
    (prompt-start)
    (System/exit 0)))
