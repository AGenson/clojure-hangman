(ns hangman.data.display
  (:require [clojure.string :as string])
  (:require [hangman.utils.output :refer [clear-print]]
            [hangman.utils.string :refer [replace-at]]))

(def scaffold-drawing
  (str "   +-------+\n"
    "   !      \\|\n"
    "           |\n"
    "           |\n"
    "           |\n"
    "           |\n"
    "============="))

(def hanging-map
  {1 {:location [2 3] :symbol \@}
   2 {:location [3 3] :symbol \|}
   3 {:location [3 2] :symbol \/}
   4 {:location [3 4] :symbol \\}
   5 {:location [4 2] :symbol \/}
   6 {:location [4 4] :symbol \\}})

(defn format-drawing
  [level]
  (reduce (fn [new-drawing [_ {:keys [location symbol]}]]
            (string/join "\n" (update (string/split-lines new-drawing)
                                      (first location)
                                      #(replace-at % (second location) symbol))))
          scaffold-drawing
          (filter #(<= (first %) level) hanging-map)))

(defn hide-word
  [word good-guesses]
  (string/replace word
                  (if (empty? good-guesses)
                    (re-pattern "[A-Z]")
                    (re-pattern (str "[A-Z&&[^" (string/join good-guesses) "]]")))
                  "*"))

(defn display-data
  ([data] (display-data data nil))
  ([{:keys [word good-guesses bad-guesses]} solution]
   (clear-print (format-drawing (count bad-guesses)))
   (println "\nYour word:"
            (if (not solution)
              (hide-word word good-guesses)
              word))
   (if (not-empty bad-guesses)
     (println "Bad guesses:" (string/join "," bad-guesses)))))
