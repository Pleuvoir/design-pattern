package io.github.pleuvoir.template;

public interface MerAccService {

	class Adapter implements MerAccService {
		@Override
		public void updateBalance(String mid) {
			System.out.println(String.format("更新商户%s余额成功", mid));
		}
	}

	void updateBalance(String mid);
}
