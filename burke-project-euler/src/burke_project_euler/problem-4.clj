(ns burke_project_euler.problem-4)

; Problem text:
; A palindromic number reads the same both ways.
; The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
;
; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindrome? [a]
  "Test if the function argument is equal to its reversal,
  doing the necessary number-to-string conversions"
  ( =
  (apply str ( reverse (str a)))
   (str a)
    )
  )

(def allproducts
  "All products of three-digit numbers"
  (for [ a (range 100 1000) b (range 100 1000)] (* a b))
  )

; Answer: filter allproducts for palindromes, then find the largest one
(apply max (filter palindrome? allproducts) ) ; expect 906609
