{
	dataSource:{
		type:'com.mchange.v2.c3p0.ComboPooledDataSource',
		events:{
			depose:'close'
		},
		fields:{
			driverClass:'com.mysql.jdbc.Driver',
			jdbcUrl:'jdbc:mysql://localhost:3306/poseidon?characterEncoding=UTF-8',
			user:'poseidon',
			password:'123456',
			maxPoolSize:20
		}
	}
}