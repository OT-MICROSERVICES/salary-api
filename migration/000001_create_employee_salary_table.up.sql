CREATE TABLE IF NOT EXISTS employee_salary (
                                             id text,
                                             process_date text,
                                             name text,
                                             salary float,
                                             status text,
                                             PRIMARY KEY (id, process_date)
) WITH CLUSTERING ORDER BY (process_date DESC);