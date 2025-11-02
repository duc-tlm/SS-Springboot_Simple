package dev.duc.tlmse.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class RoutingDatasourceImpl extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        boolean isReadOnlyTrx = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
        return isReadOnlyTrx ? DatasourceType.READ_DB : DatasourceType.WRITE_DB;
    }
}
