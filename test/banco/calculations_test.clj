(ns banco.calculations-test
  (:require [banco.calculations :as calc]
            [clojure.test :refer :all]))

(deftest slice-are
  (are [slices bands n]
    (= slices (calc/slice bands n))
    [5 2] [0 5 10] 7
    [5 5] [0 5 10] 12
    [3 5] [2 5 10] 12
    [10000 0 0 0] [0 14000 48000 75000 100000] 10000
    [14000 4000] [0 14000 48000] 18000
    [0 0 0] [0 5 10 20] 0))

(deftest tax-rate
  (are [income tax]
    (== tax (calc/calculate-tax :nz :2013-2014 income))
    0 0
    10000 1050
    20000 2520))
