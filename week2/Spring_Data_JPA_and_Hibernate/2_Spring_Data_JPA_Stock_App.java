package com.cognizant.ormlearn;

import javax.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

// ==========================================================================
// HANDSON 2: STOCK PERSISTENCE LAYER
// ==========================================================================
@Entity
@Table(name="stock")
class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="st_id")
    private int id;

    @Column(name="st_code")
    private String code;

    @Column(name="st_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name="st_open")
    private double open;

    @Column(name="st_close")
    private double close;

    @Column(name="st_volume")
    private long volume;

    public Stock() {}

    @Override
    public String toString() {
        return String.format("| %-7s | %tF | %7.2f | %8.2f | %9d |", code, date, open, close, volume);
    }
}

// ==========================================================================
// HANDSON 2: DERIVED QUERY METHODS SPECIFICATION
// ==========================================================================
@Repository
interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByCodeAndDateBetween(String code, Date start, Date end);
    List<Stock> findByCodeAndCloseGreaterThan(String code, double price);
    List<Stock> findTop3ByOrderByVolumeDesc();
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}

// --------------------------------------------------------------------------
// OUTPUTS LOGGED BELOW
// --------------------------------------------------------------------------
/*
+---------+------------+---------+----------+-----------+
| FB      | 2019-09-03 |  184.00 |   182.39 |   9779400 |
| FB      | 2019-09-04 |  184.65 |   187.14 |  11308000 |
| GOOGL   | 2019-04-22 | 1236.67 |  1253.76 |    954200 |
| GOOGL   | 2019-04-23 | 1256.64 |  1270.59 |   1593400 |

Query methods bound and loaded.
BUILD SUCCESS
*/