(ns burke_project_euler.problem-9)

; Problem text:
; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;
; a2 + b2 = c2
; For example, 32 + 42 = 9 + 16 = 25 = 52.
;
; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.

(require '[clojure.math.numeric-tower :as math])

(defn findtermc [a b]
  "Given two inputs a and b, calculate c, the square root of the sum of a^2 and b^2
   -- if c is an exact integer. If there is no integer c, output nil."
  (if (= 0 (get (math/exact-integer-sqrt (+ (math/expt b 2)
                (math/expt a 2))) 1 ) )
   (get (math/exact-integer-sqrt (+ (math/expt b 2)
                 (math/expt a 2))) 0 )
     nil ) )

(def alltriplets
  "All Pythagorean triplets where a < 1000 and b < 1000.
  The :when test makes sure findtermc returns a truthy (i.e. non-nil) value
  and that a < b, and the magic number 1000 makes sure we calculate enough
  triplets that we'll definitely find the one where a + b + c = 1000"
  (for [a (range 1 1000)
        b (range 1 1000)
         :let [c (findtermc a b)]
         :when (and c (< a b))]
          [a b c] ) )

; Answer: return the element of alltriplets where the sum of the three terms
; equals 1000
 (for [abc alltriplets
   :when  (= 1000 (reduce + abc))]
        abc) ; expect [200 375 425]
