function hideChildren(element) {
	$(element).next().toggle();
}

function collapse(clazz) {
	$(clazz).hide();
}

function expand(clazz) {
	$(clazz).show();
}
