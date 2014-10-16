(ns banco.calculations)

(def tax-rates
  {:nz {:2013-2014 [[0 0] [14000 10.5] [48000 17.5] [70000 30] [100000000 33]]}})

(defn slice
  "Slices a number into bands"
  [bands n]
  (map (fn [[lower upper]]
         (max 0 (- (min upper n) lower)))
       (partition 2 1 bands)))

(defn calculate-tax
  [country year annual-amount]
  (let [rates (get-in tax-rates [country year])]
    (apply +
      (map #(* %1 %2 0.01)
           (slice (map first rates) annual-amount)
           (rest (map second rates))))))

(def annual-amount 10000)
(def myrates (get-in tax-rates [:nz :2013-2014]))
(def slices (slice (map first myrates) 10000))
