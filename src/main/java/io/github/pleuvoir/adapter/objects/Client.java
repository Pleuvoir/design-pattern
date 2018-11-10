package io.github.pleuvoir.adapter.objects;

public class Client {
	
	public static void main(String[] args) {
		
		// 1. 各打各的包
		new Apple().pack(new AppleBag());	 // 输出  使用苹果袋进行打包
		new Orange().pack(new OrangeBag());	 // 输出  使用橘子袋进行打包
		
		
		// 2. 苹果袋不够用了，想用橘子袋进行打包
		
		//	new Apple().pack(new OrangeBag());  // 编译不通过
		
		// 在我们无法修改 pack(AppleBag appleBag) 方法形参的情况下 使用适配器模式
		// 首先我们需要制造一个 AppleBag 的形参，所以新建的适配器一定是继承了 AppleBag 类的，然后通过构造方法传 OrangeBag 进去 
		// 其实我们只需要明确，最后调用的是传入对象的  pack() 方法，围绕这个方法做替换（重写）即可
		
		new Apple().pack(new AppleAdapter(new OrangeBag())); 	// 输出  使用橘子袋进行打包
	}

	static class AppleAdapter extends AppleBag {
		private OrangeBag orangeBag;

		public AppleAdapter(OrangeBag orangeBag) {
			this.orangeBag = orangeBag;
		}

		// 重写父类方法，该方式是实际执行的方法
		@Override
		public void pack() {
		//	super.pack();
			orangeBag.pack();
		}
	}
	
}
