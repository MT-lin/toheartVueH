/*初始化页面*/
/*开始时随机产生两个2*/
window.onload=function(){
	
	//window.localStorage.setItem("mScore",0);
	//alert(window.localStorage.getItem("mScore"));
	document.getElementById("mScore").innerText=window.localStorage.getItem("mScore");
	//alert(window.localStorage.length);
	//alert(window.localStorage.getItem("mScore"));
	var box = document.getElementsByClassName("child_box");
	//colorNum();
	var nums = new Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
	var keyMove=true;
	var successNum=2048;//设置如果达到successNum时开启提示画面
	//初始化数字
	var i=0;
	i=Math.floor(Math.random()*16);
	nums[i]=2;
	i=Math.floor(Math.random()*16);
	nums[i]=2;
	getNums(nums,keyMove,successNum);
	writeNum();
	
	//键盘上下左右操作
	document.onkeydown = function(evt){
		var evt = window.event?window.event:evt;
		if(evt.keyCode==87||evt.keyCode==38){
			up(nums);
			
		}
		if(evt.keyCode==83||evt.keyCode==40){//向下
			down(nums);
		}
		if(evt.keyCode==65||evt.keyCode==37){
			right();
		}
		if(evt.keyCode==68||evt.keyCode==39){
			left();
		}
	}
	//继续游戏
	document.getElementById("continueGame").onclick =function(){
		document.getElementById("successId").style.display="none";
		document.getElementById("animationSuccessId").style.display="none";
		keyMove=true;
		if(successNum==2048){
			successNum=4096;
		}else if(successNum==4096){
			successNum=8192;
		}
		//alert(successNum);
		getNums(nums,keyMove,successNum);
		return false;
	}
	/*document.getElementById("newGame").onclick = function(){
		//alert(1);
		window.location.href="index.html";
		return false;
	}
	*/
	
}



