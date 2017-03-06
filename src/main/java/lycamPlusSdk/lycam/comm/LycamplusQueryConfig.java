package lycamPlusSdk.lycam.comm;

/**
 * @ClassName: LycamplusQueryConfig
 * @Describe: 提供公共常量：查询排序常量 
 * @Version: V0.1.0
 */
public final class LycamplusQueryConfig {
	public static enum QueryOrder {
		ASC("asc"),
		DESC("desc");
		
		private String name;
		private QueryOrder(String name) {
			this.name = name;
		}
		@Override
        public String toString() {
            return this.name;
        }
	}
	public static enum QuerySort {
		SORT_ID("id"),
		SORT_DESCRIPTION("description"),
		SORT_CREATED("created");
		
		private String name;
		private QuerySort(String name) {
			this.name = name;
		}
		@Override
        public String toString() {
            return this.name;
        }
	}
}
