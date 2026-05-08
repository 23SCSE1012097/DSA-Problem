WITH ranked_products AS (
    SELECT
        store_id,
        product_name,
        quantity,
        price,

        ROW_NUMBER() OVER (
            PARTITION BY store_id
            ORDER BY price DESC
        ) AS most_exp_rank,

        ROW_NUMBER() OVER (
            PARTITION BY store_id
            ORDER BY price ASC
        ) AS cheapest_rank

    FROM inventory
),

store_products AS (
    SELECT
        store_id,
        COUNT(*) AS product_count
    FROM inventory
    GROUP BY store_id
)

SELECT
    s.store_id,
    s.store_name,
    s.location,

    me.product_name AS most_exp_product,
    ch.product_name AS cheapest_product,

    ROUND(
        ch.quantity * 1.0 / me.quantity,
        2
    ) AS imbalance_ratio

FROM stores s

JOIN store_products sp
    ON s.store_id = sp.store_id

JOIN ranked_products me
    ON s.store_id = me.store_id
   AND me.most_exp_rank = 1

JOIN ranked_products ch
    ON s.store_id = ch.store_id
   AND ch.cheapest_rank = 1

WHERE sp.product_count >= 3
AND me.quantity < ch.quantity

ORDER BY imbalance_ratio DESC,
         s.store_name ASC;