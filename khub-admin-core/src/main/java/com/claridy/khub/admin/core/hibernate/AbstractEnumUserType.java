package com.claridy.khub.admin.core.hibernate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.AbstractStandardBasicType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.usertype.EnhancedUserType;
import org.hibernate.usertype.ParameterizedType;

public abstract class AbstractEnumUserType<E extends Enum<E>, V> implements EnhancedUserType, ParameterizedType {

    public static int DEAFAULT_SQL_TYPE = Types.INTEGER;

    private PreparedStatementSetter psSetter;

    private AbstractStandardBasicType<?> basicType;

    protected abstract Class<E> getEnumClass();

    protected abstract Class<V> getValueClass();

    protected abstract E convertEnum(V rawValue);

    protected abstract V convertSqlValue(E enumValue);

    protected int getSqlType() {
        int sqlType = Types.OTHER;
        switch (getValueClass().getName()) {
        case "java.lang.String":
            sqlType = Types.VARCHAR;
            break;
        case "java.lang.Integer":
            sqlType = Types.INTEGER;
            break;
        default:
            break;
        }

        return sqlType;
    }

    @Override
    public int[] sqlTypes() {
        return new int[] { getSqlType() };
    }

    @Override
    public Class<?> returnedClass() {
        return getEnumClass();
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return (x == y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return (x == null) ? 0 : x.hashCode();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
            throws HibernateException, SQLException {
        Object rawValue = basicType.nullSafeGet(rs, names[0], session, owner);
        Object enumValue = (rawValue == null) ? null : convertEnum((V) rawValue);
        return enumValue;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.VARCHAR);
        } else {
            psSetter.set(st, convertSqlValue((E) value), index);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    @Override
    public void setParameterValues(Properties parameters) {
        // Initialize Method
        initBasicType();
        initPreparedStatementSetter();
    }

    @Override
    public String objectToSQLString(Object value) {
        return '\'' + ((Enum<?>) value).name() + '\'';
    }

    @Override
    public String toXMLString(Object value) {
        return ((Enum<?>) value).name();
    }

    @Override
    public Object fromXMLString(String xmlValue) {
        // TODO
        throw new IllegalAccessError();
        // return Enum.valueOf(, xmlValue);
    }

    protected void initBasicType() {
        switch (getSqlType()) {
        case Types.VARCHAR:
            basicType = StringType.INSTANCE;
            break;
        case Types.INTEGER:
            basicType = IntegerType.INSTANCE;
            break;
        default:
            break;
        }
    }

    protected void initPreparedStatementSetter() {
        // TODO
        switch (getSqlType()) {
        case Types.VARCHAR:
            psSetter = new StringPreparedStatementSetter();
            break;
        case Types.INTEGER:
            psSetter = new IntPreparedStatementSetter();
        default:
            break;
        }
    }

    private static interface PreparedStatementSetter {
        void set(PreparedStatement st, Object value, int index)
                throws SQLException;
    }

    private static class StringPreparedStatementSetter implements PreparedStatementSetter {
        @Override
        public void set(PreparedStatement st, Object value, int index) {
            try {
                st.setString(index, (String) value);
            } catch (SQLException e) {
            }
        }
    }

    private static class IntPreparedStatementSetter implements PreparedStatementSetter {
        @Override
        public void set(PreparedStatement st, Object value, int index) {
            try {
                st.setInt(index, (Integer) value);
            } catch (SQLException e) {
            }
        }
    }

}