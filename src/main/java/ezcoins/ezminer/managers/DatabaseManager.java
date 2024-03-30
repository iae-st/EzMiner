package ezcoins.ezminer.managers;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import ezcoins.ezminer.EzMiner;
import ezcoins.ezminer.data.User;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String sqlhost = String.valueOf(EzMiner.plugin.getConfig().getString("MySQL.host")).replace("[", "").replace("]", "");
    private static final String sqlport = String.valueOf(EzMiner.plugin.getConfig().getString("MySQL.port")).replace("[", "").replace("]", "");
    public static final String sqldatabase = String.valueOf(EzMiner.plugin.getConfig().getString("MySQL.database_name")).replace("[", "").replace("]", "");
    private static final String sqlusername = String.valueOf(EzMiner.plugin.getConfig().getString("MySQL.username")).replace("[", "").replace("]", "");
    private static final String sqlpassword = String.valueOf(EzMiner.plugin.getConfig().getString("MySQL.password")).replace("[", "").replace("]", "");

    private final Dao<User, String> users;
    public ConnectionSource connectionSource;
    public DatabaseManager() throws SQLException {
        try {
            this.connectionSource = new JdbcConnectionSource("jdbc:mysql:" + sqlhost + ":" + sqlport + "/" + sqldatabase, sqlusername, sqlpassword);
            EzMiner.getLog().log("Connected!", true);
        } catch (SQLException mysqlException) {
            try {
                EzMiner.getLog().warn("Could not find mysql database, connecting to SQLite instead.", true);
                EzMiner.getLog().log(mysqlException.getMessage());
                String backupFolderName = "database";
                String backupFolderPath = EzMiner.getPlugin().getDataFolder().getAbsolutePath() + File.separator + backupFolderName;
                File backupFolder = new File(backupFolderPath);

                if (!backupFolder.exists()) {
                    backupFolder.mkdirs();
                }

                connectionSource = new JdbcConnectionSource("jdbc:sqlite:" + backupFolder + File.separator + "database");
            } catch (SQLException sqliteException) {
                EzMiner.getLog().error("Failed to connect to SQLite database as a fallback.", true);
                sqliteException.printStackTrace();
            }
        }
        TableUtils.createTableIfNotExists(connectionSource, User.class);
        users = DaoManager.createDao(connectionSource, User.class);
    }

}