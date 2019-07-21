package io.github.pleuvoir.adapter.objects.more;

import io.github.pleuvoir.adapter.objects.more.computer.VgaComputer;
import io.github.pleuvoir.adapter.objects.more.monitor.HdmiMonitor;
import io.github.pleuvoir.adapter.objects.more.monitor.VgaMonitor;

public class TestMain {

	public static void main(String[] args) {

		// vga电脑连接vga显示器
		VgaComputer vgaComputer = new VgaComputer();
		vgaComputer.go(new VgaMonitor());

		
		HdmiMonitor hdmiMonitor = new HdmiMonitor();
		// vga电脑难道就不能用hdmi的显示器了？
	//	vgaComputer.go(hdmiMonitor);
		
		//搞个适配器，电脑是vga电脑，他要求我传入vga的显示器，我搞个类继承vga显示器就行了，里面的实现用hdmi的，这样我vga电脑就可以使用hdmi的显示器了
		// vga电脑想用hdmi显示器，必须有人去适配
		
		
		vgaComputer.go(new Vga2HdmiAdapter(hdmiMonitor));
	}

}
