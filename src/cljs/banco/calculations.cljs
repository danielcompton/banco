(ns banco.calculations)

(defonce tax-rates
  {:nz {:2013-2014 [[14000 10.5] [48000 17.5] [70000 30] [:above 33]]}})

(defn calculate-tax
  [country year annual-amount]
  (let [rates (cons [0 nil] (get-in tax-rates [country year]))]
    (apply +
           (map (fn [[lower _] [upper tax-rate]]
                  (let [amount (- (- upper annual-amount) (- lower annual-amount))]
                    (* tax-rate amount)))
                (partition 2 1 rates)))))


